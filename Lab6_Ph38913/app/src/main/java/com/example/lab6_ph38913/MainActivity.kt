package com.example.lab6_ph38913

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontStyle
import com.example.lab6_ph38913.ui.theme.Lab6_Ph38913Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6_Ph38913Theme {
                MovieScreen(Movie.getSampleMovies())
            }
        }
    }
}

enum class ListType {
    ROW, COLUMN, GRID
}

@Composable
fun MovieItem(movie: Movie, listType: ListType) {
    if (listType == ListType.COLUMN) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp)),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontFamily = FontFamily.Default,
                    maxLines = 2
                )
                Text(
                    text = "Thời Lượng Phát: ${movie.time}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Năm phát hành: ${movie.year}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Tóm Tắt Nội Dung: ",
                    style = MaterialTheme.typography.bodyMedium,
                    fontStyle = FontStyle.Normal

                )
                Text(
                    text = "${movie.describe}",
                    style = MaterialTheme.typography.bodyMedium
                )

            }
        }
    } else {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier
                .width(175.dp)
                .height(350.dp)
        ) {
            Column {
                AsyncImage(
                    model = movie.posterUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .height(255.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp)),
                )
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontFamily = FontFamily.Default,
                        maxLines = 2
                    )
                    Text(
                        text = "Thời Lượng Phát: ${movie.time}",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "Năm phát hành: ${movie.year}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
fun MovieScreen(movies: List<Movie>) {
    var listType by remember { mutableStateOf(ListType.ROW) }
    Column {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { listType = ListType.ROW }) {
                Text("Row")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { listType = ListType.COLUMN }) {
                Text("Column")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { listType = ListType.GRID }) {
                Text("Grid")
            }
        }
        when (listType) {
            ListType.ROW -> MovieRow(movies)
            ListType.COLUMN -> MovieColumn(movies)
            ListType.GRID -> MovieGrid(movies)
        }
    }
}

@Composable
fun MovieRow(movies: List<Movie>) {
    LazyRow(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index], listType = ListType.ROW)
        }
    }
}

@Composable
fun MovieColumn(movies: List<Movie>) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index], listType = ListType.COLUMN)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieGrid(movies: List<Movie>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp), // Sử dụng GridCells.Adaptive để tự điều chỉnh cột
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index], listType = ListType.GRID)
        }
    }
}

data class Movie(
    val title: String,
    val year: String,
    val posterUrl: String,
    val time: String,
    val describe : String
) {
    companion object {
        fun getSampleMovies() = listOf(
            Movie("Trạng Quỳnh", "1/1/2014", "https://d1j8r0kxyu9tj8.cloudfront.net/images/1566809317niNpzY2khA3tzMg.jpg","180'","Bộ phim yêu thích của tôi là Frozen, một tác phẩm hoạt hình kỳ ảo của Disney. Bộ phim kể về chuyện của hai chị em Elsa và Anna ở vương quốc Arendelle"),
            Movie("Thor", "3/9/2015", "https://congthanh.vn/uploads/images/in-poster-phim-anh-dep-.jpg","300'"," Elsa sở hữu năng lực tạo ra băng và tuyết nhưng cô không thể điều khiển được nó. Cô vô tình khiến cả vương quốc bị phủ đầy băng giá và bỏ chạy lên núi. Anna quyết tâm đi tìm chị gái mình"),
            Movie("Inception", "15/4/2009", "https://arena.fpt.edu.vn/wp-content/uploads/2021/04/poster-phim-la-gi.jpg","100'"," Trên hành trình, cô kết bạn với một người tuyết tên Olaf, một chú tuần lộc tên Sven và một chàng trai tên Kristoff. Bộ phim làm tôi xúc động và được thưởng thức nhiều bài hát hay"),
            Movie("Kẻ Độc Hành", "20/11/2008", "https://i.pinimg.com/originals/02/80/9f/02809ff7a66bcfc860c072d097ab964a.jpg","600'","“Glee” là bộ phim ca nhạc hài kịch đã gây được tiếng vang lớn với khán giả trên toàn thế giới. Được sáng tạo bởi Ryan Murphy, Brad Falchuk và Ian Brennan, chương trình kể về cuộc sống "),
            Movie("Bad Girl", "2/3/2018", "https://thietkehaithanh.com/wp-content/uploads/2019/07/thietkehaithanh-poster-phim.jpg","240'","Trọng tâm của \"Glee\" là tôn vinh cá tính và sức mạnh gắn kết mọi người lại với nhau của âm nhạc. Các nhân vật, mỗi người đều có những đặc điểm và tài năng riêng, vượt qua những thử thách ở trường trung học"),
            Movie("Mai", "24/5/2003", "https://newsmd2fr.keeng.vn/tiin/archive/imageslead/2024/01/04/90_ebde803ce1532ca24e881ffa23d62fad.jpg","360'","Loạt phim không chỉ giới thiệu những màn trình diễn âm nhạc ấn tượng mà còn đề cập đến các vấn đề xã hội quan trọng, khiến bộ phim trở thành một trải nghiệm xem toàn diện và có tác động")
        )
    }
}
