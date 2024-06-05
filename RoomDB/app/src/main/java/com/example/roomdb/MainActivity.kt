package com.example.roomdb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.room.Room
import com.example.roomdb.ui.theme.RoomDBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDBTheme {
                Scaffold(
                    modifier = Modifier
                        .safeDrawingPadding()
                        .fillMaxSize()
                        .padding(16.dp)
                ) { innerPadding ->
                    Greeting(
                        name = "Quản lý Sinh viên",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        StudentDB::class.java, "student-db2"
    ).allowMainThreadQueries().build()

    var listStudents by remember {
        mutableStateOf(db.studentDAO().getAll())
    }
    var editStudent by remember { mutableStateOf<StudentModel?>(null) }

    var hoten by remember { mutableStateOf("") }
    var mssv by remember { mutableStateOf("") }
    var diemTB by remember { mutableStateOf("") }
    var daratruong by remember { mutableStateOf(false) }

    var showDialogThongtinSV by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    if (showDialogThongtinSV) {
        val tatDialog = {
            showDialogThongtinSV = false
        }
        ShowDialogStudentInfor(
            onConfirmation = tatDialog,
            dialogMessage = dialogMessage
        )
    }

    Column(Modifier.fillMaxWidth()) {
        Text(
            text = "Quản lý Sinh viên",
            style = MaterialTheme.typography.titleLarge
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            OutlinedTextField(
                label = { Text("Họ tên") },
                value = hoten,
                onValueChange = { hoten = it },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            OutlinedTextField(
                label = { Text("MSSV") },
                value = mssv,
                onValueChange = { mssv = it },
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            OutlinedTextField(
                label = { Text("Điểm TB") },
                value = diemTB,
                onValueChange = { diemTB = it },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Text("Đã ra trường?", modifier = Modifier.weight(1f))
                Checkbox(
                    checked = daratruong,
                    onCheckedChange = { daratruong = it },
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Button(onClick = {
            if (hoten.trim().isEmpty() || mssv.trim().isEmpty() || diemTB.trim().isEmpty()) {
                Toast.makeText(context, "Chưa điền đủ thông tin!", Toast.LENGTH_SHORT).show()
            } else {
                db.studentDAO().insert(
                    StudentModel(
                        hoten = hoten,
                        mssv = mssv,
                        diemTB = diemTB.toFloat(),
                        daratruong = daratruong
                    )
                )
                listStudents = db.studentDAO().getAll()
            }
        }) {
            Text(text = "Thêm SV")
        }

        LazyColumn {
            items(listStudents) { student ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            dialogMessage = student.getThongtin()
                            showDialogThongtinSV = true
                        }
                ) {
                    Text(modifier = Modifier.weight(0.5f), text = student.uid.toString())
                    Text(modifier = Modifier.weight(1f), text = student.hoten.toString())
                    Text(modifier = Modifier.weight(1f), text = student.mssv.toString())
                    Text(modifier = Modifier.weight(1f), text = student.diemTB.toString())
                    Text(modifier = Modifier.weight(1f), text = student.daratruong.toString())
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.ic_delete),
                            contentDescription = "delete",
                            modifier = Modifier.clickable {
                                db.studentDAO().deleteStudent(student.uid)
                                listStudents = db.studentDAO().getAll()
                            }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_edit),
                            contentDescription = "edit",
                            modifier = Modifier.clickable {
                                editStudent = student
                            }
                        )
                    }
                }
                Divider()
            }
        }
    }

    if (editStudent != null) {
        ShowEditStudentDialog(
            student = editStudent!!,
            onConfirmation = { editedStudent ->
                db.studentDAO().update(editedStudent)
                listStudents = db.studentDAO().getAll()
                editStudent = null
            },
            onCancel = {
                editStudent = null
            }
        )
    }
}

@Composable
fun ShowDialogStudentInfor(
    onConfirmation: () -> Unit,
    dialogTitle: String = "Thông tin SV",
    dialogMessage: String,
) {
    Dialog(onDismissRequest = {}) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            modifier = Modifier.padding(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(dialogTitle, style =
                MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(20.dp))
                Text(dialogMessage, style =
                MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = onConfirmation,

                    modifier = Modifier.align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray,
                        contentColor = Color.White
                    )
                ) {
                    Text("Okay")
                }
            }
        }
    }
}

@Composable
fun ShowEditStudentDialog(
    student: StudentModel,
    onConfirmation: (StudentModel) -> Unit,
    onCancel: () -> Unit
) {
    var editedName by remember { mutableStateOf(student.hoten ?: "") }
    var editedMSSV by remember { mutableStateOf(student.mssv ?: "") }
    var editedDiemTB by remember { mutableStateOf(student.diemTB.toString()) }
    var editedDaRaTruong by remember { mutableStateOf(student.daratruong) }

    Dialog(onDismissRequest = onCancel) {
        Card {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                OutlinedTextField(
                    value = editedName,
                    onValueChange = { editedName = it },
                    label = { Text("Họ tên") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = editedMSSV,
                    onValueChange = { editedMSSV = it },
                    label = { Text("MSSV") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = editedDiemTB,
                    onValueChange = { editedDiemTB = it },
                    label = { Text("Điểm TB") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Đã ra trường", modifier = Modifier.weight(1f))
                    editedDaRaTruong?.let {
                        Checkbox(
                            checked = it,
                            onCheckedChange = { editedDaRaTruong = it },
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            val editedStudent = student.copy(
                                hoten = editedName,
                                mssv = editedMSSV,
                                diemTB = editedDiemTB.toFloat(),
                                daratruong = editedDaRaTruong
                            )
                            onConfirmation(editedStudent)
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Lưu")
                    }
                    Button(
                        onClick = onCancel,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Hủy")
                    }
                }
            }
        }
    }
}