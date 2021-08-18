package serviceimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.StreetDao;
import entity.Street;
import util.MyBatisUtils;

public class StreetServiceImpl implements StreetDao{
    public StreetDao sd;
    public SqlSession session;
    public void util() {
    	session = MyBatisUtils.getSession();
    	sd      = session.getMapper(StreetDao.class);
    }
	@Override
	public List<Street> selectstreet() {
		 util();
		return sd.selectstreet();
	}

}
