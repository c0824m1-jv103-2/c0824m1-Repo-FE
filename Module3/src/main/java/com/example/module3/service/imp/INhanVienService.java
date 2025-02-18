package com.example.module3.service.imp;

import com.example.module3.entity.NhanVien;

import java.util.List;

public interface INhanVienService {
    List<NhanVien> getNhanVien(String TenPhongBan);
}
