package serviceimpl;

import org.apache.ibatis.session.SqlSession;

import dao.UsersDao;
import entity.Users;
import service.UsersService;
import util.MyBatisUtils;

public class UsersServiceImpl implements UsersService{
    public UsersDao ud;
    public SqlSession session;
    public void util() {
    	session = MyBatisUtils.getSession();
    	ud      = session.getMapper(UsersDao.class);
    }
	@Override
	public Users userlogin(String name, String password) {
		 util();
		return ud.userlogin(name, password);
	}

}
