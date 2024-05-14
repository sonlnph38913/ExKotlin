package com.example.lab2_ph38913

import java.util.Scanner

fun main() {
    val quanLySV = QuanLySinhVien()

    while (true) {

        println("1. Thêm sinh viên")
        println("2. Xóa sinh viên")
        println("3. Xem danh sách sinh viên")
        println("4. Thoát chương trình")
        print("Vui lòng chọn chức năng (1-4): ")
        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> quanLySV.themSinhVien()
            2 -> quanLySV.xoaSinhVien()
            3 -> quanLySV.xemDanhSachSinhVien()
            4 -> {
                println("Chương trình kết thúc.")
                return
            }
            else -> println("Lựa chọn không hợp lệ. Vui lòng thử lại.")
        }
        println("----------------------------------------")
    }
}

data class SinhVien(var ten: String, val mssv: String, var diemTB: Float, var daTotNghiep: Boolean?, var tuoi: Int?)

class QuanLySinhVien {
    private val danhSachSinhVien = arrayListOf<SinhVien>()

    fun themSinhVien() {
        val scanner = Scanner(System.`in`)
        print("Nhập tên sinh viên: ")
        val ten = readLine()
        print("Nhập MSSV: ")
        val mssv = readLine()
        print("Nhập điểm TB: ")
        val diemTB = scanner.nextFloat()
        val daTotNghiep = diemTB >= 5.0 // Kiểm tra điểm TB để xác định đã tốt nghiệp hay chưa
        print("Nhập tuổi: ")
        val tuoi = scanner.nextInt()

        val sinhVien = SinhVien(ten ?: "", mssv ?: "", diemTB, daTotNghiep, tuoi)
        danhSachSinhVien.add(sinhVien)
        println("Thêm sinh viên thành công.")
    }

    fun xemDanhSachSinhVien() {
        if (danhSachSinhVien.isEmpty()) {
            println("Danh sách sinh viên trống.")
        } else {
            println("Danh sách sinh viên:")
            for (sinhVien in danhSachSinhVien) {
                println("Tên: ${sinhVien.ten}")
                println("MSSV: ${sinhVien.mssv}")
                println("Điểm TB: ${sinhVien.diemTB}")
                println("Đã tốt nghiệp: ${sinhVien.daTotNghiep}")
                println("Tuổi: ${sinhVien.tuoi}")
                println("--------------------------")
            }
        }
    }

    fun xoaSinhVien() {
        print("Nhập MSSV của sinh viên cần xóa: ")
        val mssv = readLine()

        val sinhVien = danhSachSinhVien.find { it.mssv == mssv }
        if (sinhVien == null) {
            println("Không tìm thấy sinh viên với MSSV đã nhập.")
        } else {
            danhSachSinhVien.remove(sinhVien)
            println("Xóa sinh viên thành công.")
        }
    }
}


class Lab2_B4 {
}