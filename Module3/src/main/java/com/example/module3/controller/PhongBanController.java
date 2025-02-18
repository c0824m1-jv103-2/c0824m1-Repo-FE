package com.example.module3.controller;

import com.example.module3.entity.NhanVien;
import com.example.module3.entity.PhongBan;
import com.example.module3.service.NhanVienService;
import com.example.module3.service.PhongBanService;
import com.example.module3.service.imp.INhanVienService;
import com.example.module3.service.imp.IPhongBanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongBanController", urlPatterns = "/phongban")
public class PhongBanController extends HttpServlet {
    private final IPhongBanService phongBanService = new PhongBanService();
    private final INhanVienService nhanVienService = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "PhongBan":
                phongBan(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "searchPhongBan":
                searchPhongBan(req, resp);
                break;

        }
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
