package serviceimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.HouseDao;
import entity.House;
import util.MyBatisUtils;

public class HouseServiceImpl implements HouseDao{
    public HouseDao hd;
    public SqlSession session;
    public void util() {
    	session = MyBatisUtils.getSession();
    	hd      = session.getMapper(HouseDao.class);
    }
	@Override
	public List<House> mohuselect(House house) {
		 util();
		 
		return hd.mohuselect(house);
	}
     
}
