package com.example.lab2_ph38913

import java.util.Scanner


class SinhVienB8(val hoTen: String, val tuoi: Int, val lop: String)

class TheMuon(val maPhieuMuon: String, val ngayMuon: String, val hanTra: String, val soHieuSach: String, val sinhVienB8: SinhVienB8)

class QuanLyTheMuon {
    private val danhSachTheMuon = mutableListOf<TheMuon>()

    fun themTheMuon(the: TheMuon) {
        danhSachTheMuon.add(the)
    }

    fun xoaTheMuon(maPhieuMuon: String) {
        val iterator = danhSachTheMuon.iterator()
        while (iterator.hasNext()) {
            val the = iterator.next()
            if (the.maPhieuMuon == maPhieuMuon) {
                iterator.remove()
                println("Đã xoá thẻ mượn có mã số $maPhieuMuon")
                return
            }
        }
        println("Không tìm thấy thẻ mượn có mã số $maPhieuMuon")
    }

    fun hienThiDanhSachTheMuon() {
        println("----- DANH SÁCH THẺ MƯỢN -----")
        for (the in danhSachTheMuon) {
            println("Mã phiếu mượn: ${the.maPhieuMuon}, Ngày mượn: ${the.ngayMuon}, Hạn trả: ${the.hanTra}, Số hiệu sách: ${the.soHieuSach}, Sinh viên: ${the.sinhVienB8.hoTen}")
        }
        println("---------------------------------")
    }
}

fun main() {
    val quanLyTheMuon = QuanLyTheMuon()
    val scanner = Scanner(System.`in`)

    var luaChon: Int
    do {
        println("----- MENU -----")
        println("1. Thêm thẻ mượn")
        println("2. Xoá thẻ mượn")
        println("3. Hiển thị danh sách thẻ mượn")
        println("4. Thoát")
        print("Chọn chức năng (1-4): ")
        luaChon = scanner.nextInt()

        when (luaChon) {
            1 -> {
                println("Nhập thông tin thẻ mượn:")
                print("Mã phiếu mượn: ")
                val maPhieuMuon = scanner.next()
                print("Ngày mượn: ")
                val ngayMuon = scanner.next()
                print("Hạn trả: ")
                val hanTra = scanner.next()
                print("Số hiệu sách: ")
                val soHieuSach = scanner.next()
                print("Họ tên sinh viên: ")
                val hoTen = scanner.nextLine()
                scanner.nextLine()
                print("Tuổi sinh viên: ")
                val tuoi = scanner.nextInt()
                scanner.nextLine()
                print("Lớp sinh viên: ")
                val lop = scanner.next()

                val sinhVienBai8 = SinhVienB8(hoTen, tuoi, lop)
                val theMuon = TheMuon(maPhieuMuon, ngayMuon, hanTra, soHieuSach, sinhVienBai8)
                quanLyTheMuon.themTheMuon(theMuon)
                println("Đã thêm thẻ mượn thành công!")
            }
            2 -> {
                print("Nhập mã phiếu mượn cần xoá: ")
                val maPhieuMuon = scanner.next()
                quanLyTheMuon.xoaTheMuon(maPhieuMuon)
            }
            3 -> {
                quanLyTheMuon.hienThiDanhSachTheMuon()
            }
            4 -> println("Thoát chương trình")
            else -> println("Lựa chọn không hợp lệ! Vui lòng chọn lại.")
        }
    } while (luaChon != 4)
}

class Bai8 {
}