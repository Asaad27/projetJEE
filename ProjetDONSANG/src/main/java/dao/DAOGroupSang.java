package dao;

import beans.GroupSang;

import java.util.List;

public interface DAOGroupSang {
    public List<GroupSang> lister() throws DAOException;
}
