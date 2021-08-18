package serviceimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.DistrictDao;
import util.MyBatisUtils;

public class DistrictServiceImpl implements DistrictDao{
    public DistrictDao dd;
    public SqlSession session;
    
    public void util() {
    	session = MyBatisUtils.getSession();
    	dd      = session.getMapper(DistrictDao.class);
    }
	@Override
	public List<DistrictDao> selectdistrict() {
		 
		return dd.selectdistrict();
	}
     
}
