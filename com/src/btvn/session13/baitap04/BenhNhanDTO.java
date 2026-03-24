package btvn.session13.baitap04;

import java.sql.*;
import java.util.*;

class BenhNhanDTO {
    int maBenhNhan;
    String tenBenhNhan;
    List<Dichvu> dsDichVu = new ArrayList<>();
    public BenhNhanDTO(int ma, String ten) {
        this.maBenhNhan = ma;
        this.tenBenhNhan = ten;
    }
}