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
    <img src="https://media.istockphoto.com/id/1283536918/vi/vec-to/ch%C3%A0o-m%E1%BB%ABng-kh%C3%A1i-ni%E1%BB%87m-ph%E1%BA%B3ng-vector-k%E1%BA%BB-th%C3%B9-trang-web-nh%E1%BB%AFng-ng%C6%B0%E1%BB%9Di-nh%E1%BB%8F-b%C3%A9-h%E1%BA%A1nh-ph%C3%BAc-%C4%91ang-%E1%BB%9F-g%E1%BA%A7n.jpg?s=612x612&w=0&k=20&c=oHphbJe9UWlI4O3Up-HzJ8Mc6Yy6Bg8bYu1BqlUk59E=" alt="Welcome">
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
    <button onclick="window.location.href='/phongban?action=khenThuong';">Khen thưởng & Phạt</button>
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
                    <td><c:out value="${nhanvien.getNgayFormatted()}"/></td>
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
