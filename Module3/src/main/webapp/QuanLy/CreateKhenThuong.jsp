<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Khen Thưởng / Phạt</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #1a237e, #3d5afe);
            color: white;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .container {
            background: rgba(255, 255, 255, 0.2);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .form-control, .form-select, textarea {
            background: rgba(255, 255, 255, 0.8);
            color: black;
            border: none;
        }
        .form-control:focus, .form-select:focus, textarea:focus {
            background: white;
            box-shadow: 0 0 5px rgba(255, 255, 255, 0.8);
        }
        .btn-primary {
            background-color: #ffeb3b;
            color: black;
            border: none;
        }
        .btn-primary:hover {
            background-color: #fdd835;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Nhập Thông Tin Khen Thưởng / Phạt</h2>
    <form  method="post">
        <div class="mb-3">
            <label class="form-label">Mã Nhân Viên:</label>
            <select class="form-select" name="tenPhongBan" id="tenPhongBan" required>
                <option value="" selected>-- Mã nhân viên --</option>
                <c:forEach var="item" items="${PhongBan}">
                    <option value="${item.getTenPhongBan()}">
                            ${item.getTenPhongBan()}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Loại:</label>
            <select class="form-select" name="Loai" required>
                <option value="Khen thưởng">Khen thưởng</option>
                <option value="Phạt">Phạt</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Số Tiền:</label>
            <input type="number" step="0.01" class="form-control" name="SoTien" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Lý Do:</label>
            <textarea class="form-control" name="LyDo" rows="3" required></textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Ngày:</label>
            <input type="date" class="form-control" name="Ngay" required>
        </div>

        <div class="d-flex justify-content-between">
            <button type="button" class="btn btn-secondary" onclick="history.back()">Quay lại</button>
            <button type="submit" class="btn btn-primary">Lưu</button>
        </div>
    </form>
</div>
</body>
</html>