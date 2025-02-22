<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Khen Thưởng / Phạt</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Nhập Thông Tin Khen Thưởng / Phạt</h2>
    <form  method="post">
        <div class="mb-3">
            <label class="form-label">Mã Nhân Viên:</label>
            <input type="text" class="form-control" name="Ma" required>
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
