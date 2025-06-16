# 📚 Hệ Thống Quản Lý Ấn Phẩm Thư Viện

[![Java Version](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]
[![Version](https://img.shields.io/badge/Version-1.0.0-blue.svg)]

## 🎯 Tổng Quan
Hệ thống Quản lý Ấn phẩm Thư viện là một ứng dụng Java được phát triển dựa trên các nguyên tắc OOP, giúp quản lý hiệu quả các loại ấn phẩm trong thư viện như sách, tạp chí và báo. Hệ thống sử dụng XML làm cơ sở dữ liệu, đảm bảo tính linh hoạt và dễ dàng trong việc lưu trữ thông tin.

### Mục Tiêu
- Quản lý thông tin ấn phẩm (sách, tạp chí, báo)
- Theo dõi trạng thái mượn/trả
- Lưu trữ dữ liệu bằng XML
- Giao diện người dùng thân thiện

## ✨ Tính Năng Chính

### 1. Quản Lý Ấn Phẩm
- Thêm, xóa, cập nhật thông tin ấn phẩm
- Phân loại theo loại ấn phẩm:
  - Sách
  - Tạp chí
  - Báo
- Quản lý thông tin chi tiết:
  - Tên ấn phẩm
  - Tác giả/Nhà xuất bản
  - Năm phát hành
  - Thể loại

### 2. Tìm Kiếm và Lọc
- Tìm kiếm theo:
  - Tên ấn phẩm
  - Tác giả/Nhà xuất bản
  - Năm phát hành
  - Thể loại
- Sắp xếp theo:
  - Tên (A-Z)
  - Năm xuất bản
  - Trạng thái mượn/trả

### 3. Quản Lý Mượn/Trả
- Đánh dấu trạng thái mượn/trả
- Tự động cập nhật XML
- Theo dõi lịch sử mượn/trả

### 4. Quản Lý Dữ Liệu
- Lưu trữ dữ liệu dưới dạng XML:
  - AnPham.xml
  - Sach.xml
  - TapChi.xml
  - Bao.xml
  - QuanLyAnPhamThuVien.xml
  - NguoiDung.xml
- Danh sách mượn/trả (danhsachmuontra.txt)

## 🛠 Công Nghệ Sử Dụng
- Java 17+
- XML (JAXB) cho lưu trữ dữ liệu
- Swing cho giao diện người dùng
- JCalendar cho quản lý ngày tháng
- JUnit cho kiểm thử
- Maven cho quản lý dự án

## 🛠 Cài Đặt

### Yêu Cầu Hệ Thống
- Java Runtime Environment (JRE)
- IDE hỗ trợ Java (NetBeans)
- Thư viện jcalendar-1.4.jar

### Cài Đặt
1. Clone repository:
   ```bash
   git clone [repository-url]
   cd QuanLyAnPhamThuVien
   ```

2. Mở project trong NetBeans IDE

3. Build và chạy project:
   - Clean and Build project
   - Run project

## 💻 Sử Dụng

### Quản Lý Ấn Phẩm
1. Thêm ấn phẩm mới:
   - Chọn loại ấn phẩm (Sách/Tạp chí/Báo)
   - Nhập thông tin chi tiết
   - Lưu thông tin

2. Cập nhật thông tin:
   - Tìm kiếm ấn phẩm
   - Chỉnh sửa thông tin
   - Lưu thay đổi

3. Xóa ấn phẩm:
   - Tìm kiếm ấn phẩm
   - Xác nhận xóa

### Quản Lý Mượn/Trả
1. Mượn ấn phẩm:
   - Chọn ấn phẩm
   - Đánh dấu "Đã mượn"
   - Hệ thống tự động cập nhật XML

2. Trả ấn phẩm:
   - Chọn ấn phẩm
   - Đánh dấu "Đã trả"
   - Hệ thống tự động cập nhật XML

## 📁 Cấu Trúc Project

### Thư Mục Chính
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── mycompany/
│   │           └── quanlyanphamthuvien/
│   │               ├── action/
│   │               ├── controller/
│   │               ├── entity/
│   │               ├── main/
│   │               ├── utils/
│   │               └── view/
│   └── resources/
└── test/
```

### File XML
- `AnPham.xml`: Thông tin chung về ấn phẩm
- `Sach.xml`: Thông tin sách
- `TapChi.xml`: Thông tin tạp chí
- `Bao.xml`: Thông tin báo
- `QuanLyAnPhamThuVien.xml`: Cấu hình hệ thống
- `NguoiDung.xml`: Thông tin người dùng

## 🤝 Đóng Góp
Mọi đóng góp đều được hoan nghênh. Vui lòng:

1. Fork dự án
2. Tạo branch mới
3. Commit thay đổi
4. Push lên branch
5. Tạo Pull Request

## 📞 Liên Hệ
- **Tác Giả**: [BaThien,AnhTuan,ManhChi]
- **GitHub**: [github.com/pathin33,github.com/NguyenDuyAnhTuan,github.com/ChiNguyenxK5]

## ❓ FAQ

### Câu Hỏi Thường Gặp
1. **Làm thế nào để thêm ấn phẩm mới?**
   - Sử dụng form thêm ấn phẩm trong giao diện
   - Hoặc import từ file Excel/CSV

2. **Cách xử lý khi ấn phẩm bị mất?**
   - Đánh dấu trạng thái "Mất"
   - Ghi nhận thông tin bồi thường
   - Cập nhật kho

3. **Làm sao để sao lưu dữ liệu?**
   - Sử dụng tính năng Export
   - Hoặc sao chép file XML

4. **Cách cập nhật phiên bản mới?**
   - Tải phiên bản mới
   - Sao lưu dữ liệu
   - Cập nhật theo hướng dẫn



## 🔧 Xử Lý Lỗi Thường Gặp

### Lỗi Khi Chạy Ứng Dụng
1. **Lỗi Java Version**
   - Kiểm tra phiên bản Java: `java -version`
   - Cài đặt Java 17 nếu chưa có

2. **Lỗi XML**
   - Kiểm tra quyền truy cập file XML
   - Đảm bảo cấu trúc XML hợp lệ
   - Sao lưu file XML trước khi sửa

3. **Lỗi Giao Diện**
   - Kiểm tra thư viện jcalendar-1.4.jar
   - Xóa cache của IDE
   - Clean và Build lại project

## 🚀 Quy Trình Phát Triển

### Quy Trình Làm Việc
1. Tạo branch mới cho tính năng
2. Phát triển và kiểm thử
3. Code review
4. Merge vào main branch

### Kiểm Thử
- Unit test cho các thành phần
- Integration test cho luồng dữ liệu
- UI test cho giao diện
- Performance test cho hiệu suất

## 📄 Giấy Phép

Dự án này được cấp phép theo giấy phép MIT - xem file [LICENSE](LICENSE) để biết thêm chi tiết.

### Điều Khoản Sử Dụng
- Được phép sử dụng cho mục đích thương mại
- Được phép sửa đổi và phân phối
- Được phép sử dụng riêng tư
- Giữ nguyên thông báo bản quyền


