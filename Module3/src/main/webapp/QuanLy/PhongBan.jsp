<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý sinh viên</title>
    <link rel="stylesheet" href="/css/Table.css">
    <link rel="stylesheet" href="/css/Home.css">
</head>
<body>
<div class="sidebar">
    <img src="https://via.placeholder.com/100" alt="Welcome">
    <form action="/phongban?action=searchPhongBan" method="post">
        <select name="tenPhongBan" id="tenPhongBan">
            <option value="" selected>-- Tổng danh sách --</option>
            <c:forEach items="${PhongBan}" var="phongban">
                <option value="${phongban.getTenPhongBan()}">
                        ${phongban.getTenPhongBan()}
                </option>
            </c:forEach>
        </select>
        <button type="submit">Chọn</button>
    </form>
    <button>Thêm Mới Nhân Viên</button>
    <button>Khen thưởng & Phạt</button>
    <button>Dự án</button>
</div>
<div class="content">
    <h2>Danh sách Nhân Viên</h2>
    <div class="employee-card">
        <table>
            <tr>
                <th>STT</th>
                <th>Họ và tên</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Chức vụ</th>
                <th>Email</th>
                <th>CCCD</th>
                <th>Tên phòng ban</th>
            </tr>
            <c:forEach items="${NhanViens}" var="nhanvien" varStatus="loop">
                <tr>
                    <td><c:out value="${loop.count}"/></td>
                    <td><c:out value="${nhanvien.getHoTen()}"/></td>
                    <td><c:out value="${nhanvien.getNgaySinh()}"/></td>
                    <td><c:out value="${nhanvien.getGioiTinh()}"/></td>
                    <td><c:out value="${nhanvien.getChucVu()}"/></td>
                    <td><c:out value="${nhanvien.getEmail()}"/></td>
                    <td><c:out value="${nhanvien.getCCCD()}"/></td>
                    <td><c:out value="${nhanvien.getPhongBan().getTenPhongBan()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
