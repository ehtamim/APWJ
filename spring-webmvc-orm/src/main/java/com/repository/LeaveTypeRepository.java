package com.repository;

import com.domain.LeaveType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeaveTypeRepository {
    private SessionFactory sessionFactory;

    public LeaveTypeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean create(LeaveType leaveType) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(leaveType);
        return true;
    }
}
