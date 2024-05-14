package com.example.lab2_ph38913
import java.util.Scanner


open class Nguoi(val hoTen: String, val tuoi: Int, val queQuan: String, val maSoGV: String)


class CBGV(hoTen: String, tuoi: Int, queQuan: String, maSoGV: String,
           val luongCung: Double, val luongThuong: Double, val tienPhat: Double) : Nguoi(hoTen, tuoi, queQuan, maSoGV) {
    fun tinhLuongThucLinh(): Double {
        return luongCung + luongThuong - tienPhat
    }
}
class QuanLyCBGV {
    private val danhSachCBGV = mutableListOf<CBGV>()

    fun themCBGV(gv: CBGV) {
        danhSachCBGV.add(gv)
    }

    fun xoaCBGV(maSoGV: String) {
        val iterator = danhSachCBGV.iterator()
        while (iterator.hasNext()) {
            val gv = iterator.next()
            if (gv.maSoGV == maSoGV) {
                iterator.remove()
                println("Đã xoá giáo viên có mã số $maSoGV")
                return
            }
        }
        println("Không tìm thấy giáo viên có mã số $maSoGV")
    }

    fun timCBGV(maSoGV: String): CBGV? {
        for (gv in danhSachCBGV) {
            if (gv.maSoGV == maSoGV) {
                return gv
            }
        }
        return null
    }

    fun hienThiDanhSach() {
        println("----- DANH SÁCH GIÁO VIÊN -----")
        for (gv in danhSachCBGV) {
            println("Họ tên: ${gv.hoTen}, Tuổi: ${gv.tuoi}, Quê quán: ${gv.queQuan}, Mã số GV: ${gv.maSoGV}")
        }
        println("---------------------------------")
    }
}

fun main() {
    val quanLy = QuanLyCBGV()
    val scanner = Scanner(System.`in`)
    var luaChon: Int
    do {
        println("----- MENU -----")
        println("1. Thêm giáo viên")
        println("2. Xóa giáo viên")
        println("3. Tính lương thực lĩnh của giáo viên")
        println("4. Hiển thị danh sách giáo viên")
        println("5. Thoát")
        print("Chọn chức năng (1-5): ")
        luaChon = scanner.nextInt()

        when (luaChon) {
            1 -> {
                // Thêm giáo viên
                println("Nhập thông tin giáo viên:")
                print("Họ tên: ")
                val hoTen = scanner.nextLine()
                scanner.nextLine()
                print("Tuổi: ")
                val tuoi = scanner.nextInt()
                print("Quê quán: ")
                val queQuan = scanner.nextLine()
                scanner.nextLine()
                print("Mã số giáo viên: ")
                val maSoGV = scanner.next()
                print("Lương cứng: ")
                val luongCung = scanner.nextDouble()
                print("Lương thưởng: ")
                val luongThuong = scanner.nextDouble()
                print("Tiền phạt: ")
                val tienPhat = scanner.nextDouble()

                val gv = CBGV(hoTen, tuoi, queQuan, maSoGV, luongCung, luongThuong, tienPhat)
                quanLy.themCBGV(gv)
                println("Đã thêm giáo viên thành công!")
            }
            2 -> {
                // Xóa giáo viên
                print("Nhập mã số giáo viên cần xoá: ")
                val maSoGV = scanner.next()
                quanLy.xoaCBGV(maSoGV)
            }
            3 -> {
                // Tính lương thực lĩnh
                print("Nhập mã số giáo viên cần tính lương: ")
                val maSoGV = scanner.next()
                val gv = quanLy.timCBGV(maSoGV)
                if (gv != null) {
                    println("${gv.hoTen} có lương thực lĩnh là ${gv.tinhLuongThucLinh()}")
                } else {
                    println("Không tìm thấy giáo viên có mã số $maSoGV")
                }
            }
            4 -> {
                // Hiển thị danh sách giáo viên
                quanLy.hienThiDanhSach()
            }
            5 -> println("Thoát chương trình")
            else -> println("Lựa chọn không hợp lệ! Vui lòng chọn lại.")
        }
    } while (luaChon != 5)
}

class Bai7 {
}