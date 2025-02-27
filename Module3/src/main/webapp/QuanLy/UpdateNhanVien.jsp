<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/22/2025
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/update.css">
</head>
<body>
<div class="container">
    <h2>Tạo mới nhân viên</h2>
    <form action="/phongban?action=updateNhanVien" method="post">
        <div class="form-group">
            <label for="HoTen">Họ và tên</label>
            <input type="text" class="form-control" id="HoTen" name="HoTen" value="${nhanvien.getHoTen()}"
                   placeholder="Nhập họ và tên ">
        </div>
        <div class="form-group">
            <label for="NgaySinh">Ngày sinh</label>
            <input type="date" class="form-control" id="NgaySinh" name="NgaySinh" value="${nhanvien.getNgaySinh()}"
                   placeholder="Nhập ngày sinh">
        </div>
        <div class="form-group">
            <label>Giới tính</label>
            <select name="GioiTinh">
                <option value="${nhanvien.getMaNV()}">${nhanvien.getGioiTinh()}</option>
                <c:forEach items="${nhanVien}" var="nv">
                    <option value="${nv.getGioiTinh()}">${nv.getGioiTinh()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Chức vụ</label>
            <input type="text" name="ChucVu" value="${nhanvien.getChucVu()}">
        </div>
        <div class="form-group">
            <label>Địa chỉ email</label>
            <input type="email" name="Email" value="${nhanvien.getEmail()}">
        </div>

        <div class="form-group">
            <label>Số CMND/CCCD</label>
            <input type="text" name="CCCD" value="${nhanvien.getCCCD()}">
        </div>
        <div class="form-group">
            <label>Tên phòng ban</label>
            <select name="TenPhongBan">
                <option value="${phongBan.getMaPhongBan()}">${phongBan.getTenPhongBan()}</option>
                <c:forEach items="${PhongBanList}" var="PhongBanList">
                    <option value="${PhongBanList.getMaPhongBan()}">${PhongBanList.getTenPhongBan()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="buttons">
            <button type="submit" class="save">Lưu lại</button>
            <button type="button" class="cancel" onclick="window.history.back();">Hủy bỏ</button>
        </div>
    </form>
</div>
</body>
</html>
