package jun.dao;

import java.util.List;

import jun.entity.LinkMan;

public interface LinkManDao {

	void addLinkMan(LinkMan linkMan);

	LinkMan findOne(int linkid);

	List<LinkMan> findCondition(LinkMan linkMan);

	List<LinkMan> list();

}
