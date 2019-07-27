package com;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 
 * @Description
 * <p>基于范型的连接数据库模板</p>
 * <p></p>
 * <p></p>
 * @author WangZhen
 * @CreateIn 2019年6月27日 下午4:05:59
 * @Version 1.0
 */
public class C3P0Utils {
	private final static DataSource ds = new ComboPooledDataSource();
	public static DataSource getDataSource(){
		return ds;
	}
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public static <T> T select(Class<T> c,String sql){
		Connection conn = null;
		T t = null;
		try {
			conn = ds.getConnection();
			QueryRunner qr = new QueryRunner(ds);
			t = (T) qr .query(conn, sql, new BeanHandler<T>(c));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	public static <T> T select(Class<T> c,String sql,Object params[]){
		Connection conn = null;
		T t = null;
		try {
			conn = ds.getConnection();
			QueryRunner qr = new QueryRunner(ds);
			t = (T) qr .query(conn, sql, new BeanHandler<T>(c),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	public static <T> T select(Class<T> c,String sql,String...params){
		Connection conn = null;
		T t = null;
		try {
			conn = ds.getConnection();
			QueryRunner qr = new QueryRunner(ds);
			t = (T) qr .query(conn, sql, new BeanHandler<T>(c),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	public static <T> List<T> selectList(Class<T> c,String sql){
		Connection conn = null;
		List<T> list = null;
		try {
			conn = ds.getConnection();
			QueryRunner qr = new QueryRunner(ds);
			list = (List<T>) qr.query(conn, sql, new BeanListHandler<T>(c));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public static <T> List<T> selectList(Class<T> c,String sql,Object params[]){
		Connection conn = null;
		List<T> list = null;
		try {
			conn = ds.getConnection();
			QueryRunner qr = new QueryRunner(ds);
			list = (List<T>) qr.query(conn, sql, new BeanListHandler<T>(c),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public static <T> List<T> selectList(Class<T> c,String sql,String...params){
		Connection conn = null;
		List<T> list = null;
		try {
			conn = ds.getConnection();
			QueryRunner qr = new QueryRunner(ds);
			list = (List<T>) qr.query(conn, sql, new BeanListHandler<T>(c),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public static <V, K> Map<K,V> selectMap(Class<K> key,Class<V> value,String sql){
		Connection conn = null;
		Map<K,V> map = null;
		try {
			conn = ds.getConnection();
			QueryRunner qr = new QueryRunner(ds);
			map = (Map<K,V>) qr.query(conn, sql, new BeanMapHandler<K,V>(value));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	public static <V, K> Map<K,V> selectMap(Class<K> key,Class<V> value,String sql,Object params[]){
		Connection conn = null;
		Map<K,V> map = null;
		try {
			conn = ds.getConnection();
			QueryRunner qr = new QueryRunner(ds);
			map = (Map<K,V>) qr.query(conn, sql, new BeanMapHandler<K,V>(value),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	public static <V, K> Map<K,V> selectMap(Class<K> key,Class<V> value,String sql,String...params){
		Connection conn = null;
		Map<K,V> map = null;
		try {
			conn = ds.getConnection();
			QueryRunner qr = new QueryRunner(ds);
			map = (Map<K,V>) qr.query(conn, sql, new BeanMapHandler<K,V>(value),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	public static boolean update(String sql){
		Connection conn = null;
		try {
			QueryRunner qr = new QueryRunner(ds);
			conn = ds.getConnection();
			return qr.update(conn, sql)>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean update(String sql,Object params[]){
		Connection conn = null;
		try {
			QueryRunner qr = new QueryRunner(ds);
			conn = ds.getConnection();
			return qr.update(conn, sql, params)>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean update(String sql,String...params){
		Connection conn = null;
		try {
			QueryRunner qr = new QueryRunner(ds);
			conn = ds.getConnection();
			return qr.update(conn, sql, params)>0?true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
