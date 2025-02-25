package com.example.module3.repository;

import com.example.module3.entity.PhongBan;
import com.example.module3.repository.imp.IPhongBanRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhongBanRepository implements IPhongBanRepository {
    private final String SELECT_PHONGBAN = "SELECT * FROM phongban";

    @Override
    public List<PhongBan> findAll() {
        Connection connection = BaseRepository.getConnection();
        List<PhongBan> phongBans = new ArrayList<PhongBan>();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_PHONGBAN))
        {
            while (resultSet.next()) {
                int MaPhongBan = resultSet.getInt("MaPhongBan");
                String TenPhongBan = resultSet.getString("TenPhongBan");
                PhongBan phongBan = new PhongBan(MaPhongBan, TenPhongBan);
                phongBans.add(phongBan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongBans;
    }
}
