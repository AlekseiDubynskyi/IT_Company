package com.solvd.it_company.dao.mybatis.Impl;

import com.solvd.it_company.connection.MyBatisUtil;
import com.solvd.it_company.dao.ICategoriesDAO;
import com.solvd.it_company.models.Categories;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class CategoriesMapperDAO implements ICategoriesDAO {
    private static final Logger LOGGER = LogManager.getLogger(CategoriesMapperDAO.class);

    @Override
    public Categories getCategoryById(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Categories categories = session.selectOne("src.main.resources.mappers.CategoriesMapper.getCategoryById", id);
        session.close();
        return categories;
    }

    @Override
    public List<Categories> getAllCategories() {
        List<Categories> categories = new LinkedList<>();
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        categories = session.selectList("src.main.resources.mappers.CategoriesMapper.getAllCategories", categories);
        session.close();
        categories.forEach(LOGGER::info);
        return categories;
    }

    @Override
    public void addCategory(Categories categories) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("src.main.resources.mappers.CategoriesMapper.addCategory", categories);
        session.commit();
        session.close();
    }

    @Override
    public void updateCategory(Categories categories) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("src.main.resources.mappers.CategoriesMapper.updateCategory", categories);
        session.commit();
        session.close();
    }

    @Override
    public void deleteCategory(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("src.main.resources.mappers.CategoriesMapper.deleteCategory", id);
        session.commit();
        session.close();
    }
}
