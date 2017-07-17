package jun.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jun.dao.LinkManDao;
import jun.entity.LinkMan;

@Transactional
public class LinkManService {

	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	public void addLinkMan(LinkMan linkMan) {
		
		linkManDao.addLinkMan(linkMan);
	}

	public LinkMan findOne(int linkid) {
		// TODO Auto-generated method stub
		return linkManDao.findOne(linkid);
	}

	public List<LinkMan> findCondition(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return linkManDao.findCondition(linkMan);
	}

	public List<LinkMan> list() {
		// TODO Auto-generated method stub
		return linkManDao.list();
	}
	
}
