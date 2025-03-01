package com.example.module3.controller;

import com.example.module3.entity.KhenThuong;
import com.example.module3.entity.NhanVien;
import com.example.module3.entity.PhongBan;
import com.example.module3.service.KhenThuongService;
import com.example.module3.service.NhanVienService;
import com.example.module3.service.PhongBanService;
import com.example.module3.service.imp.IKhenThuongService;
import com.example.module3.service.imp.INhanVienService;
import com.example.module3.service.imp.IPhongBanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "PhongBanController", urlPatterns = "/phongban")
public class PhongBanController extends HttpServlet {
    private final IPhongBanService phongBanService = new PhongBanService();
    private final INhanVienService nhanVienService = new NhanVienService();
    private final IKhenThuongService khenThuongService = new KhenThuongService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "loaiKhenThuong":
                loaiKhenThuong(req, resp);
                break;
            case "khenThuong":
                khenThuongList(req, resp);
                break;
            case "deleteKhenThuong":
                deleteKhenThuong(req, resp);
                break;
            case "createKhenThuong":
                List<NhanVien> nhanViens = nhanVienService.findAllMaNV();
                req.setAttribute("nhanViens", nhanViens);
                req.getRequestDispatcher("/QuanLy/CreateKhenThuong.jsp").forward(req, resp);
                break;
            default:
                phongBan(req, resp);
                break;
        }
    }

    private void loaiKhenThuong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KhenThuong> khenThuongs;
        String loai = req.getParameter("id");
        if (loai == null || loai.isEmpty()) {
            khenThuongs = khenThuongService.getKhenThuongList();
        } else {
            khenThuongs = khenThuongService.findByLoai(loai);
        }
        req.setAttribute("khenThuongs", khenThuongs);
        req.getRequestDispatcher("/QuanLy/KhenThuong.jsp").forward(req, resp);
    }

    private void deleteKhenThuong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int Ma = Integer.parseInt(req.getParameter("id"));
        khenThuongService.remove(Ma);
        khenThuongList(req, resp);
    }


    private void khenThuongList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KhenThuong> khenThuongs = khenThuongService.getKhenThuongList();
        req.setAttribute("khenThuongs", khenThuongs);
        req.getRequestDispatcher("/QuanLy/KhenThuong.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createKhenThuong":
                createKhenThuong(req, resp);
                break;
            case "searchPhongBan":
                searchPhongBan(req, resp);
                break;
        }
    }

    private void createKhenThuong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int Ma = Integer.parseInt(req.getParameter("Ma"));
        String Loai = req.getParameter("Loai");
        float SoTien = Float.parseFloat(req.getParameter("SoTien"));
        String LyDo = req.getParameter("LyDo");
        LocalDate Ngay = LocalDate.parse(req.getParameter("Ngay"));
        KhenThuong khenThuong = new KhenThuong(Ma, Loai, SoTien, LyDo, Ngay);
        khenThuongService.save(khenThuong);
        resp.sendRedirect("/phongban?action=khenThuong");
    }

    private void searchPhongBan(HttpServletRequest req, HttpServletResponse resp) {
        String tenPhongBan = req.getParameter("tenPhongBan");
        req.setAttribute("tenPhongBan", tenPhongBan);
        List<PhongBan> PhongBan = phongBanService.getPhongBanList();
        req.setAttribute("PhongBan", PhongBan);
        List<NhanVien> NhanViens = nhanVienService.getNhanVien(tenPhongBan);
        req.setAttribute("NhanViens", NhanViens);
        RequestDispatcher dispatcher = req.getRequestDispatcher("QuanLy/PhongBan.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void phongBan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PhongBan> PhongBan = phongBanService.getPhongBanList();
        req.setAttribute("PhongBan", PhongBan);
        List<NhanVien> NhanViens = nhanVienService.getNhanVien("");
        req.setAttribute("NhanViens", NhanViens);
        RequestDispatcher dispatcher = req.getRequestDispatcher("QuanLy/PhongBan.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
