package springboard.common.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {
	protected Log log = LogFactory.getLog(AbstractDao.class);

	@Autowired
	private SqlSessionTemplate sqlSession;

	protected void printQueryId(String queryId) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("\tQuery Id [" + queryId + "]");
		}
	}

	public Object insert(String queryId, Object params) throws Exception {
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}

	public Object update(String queryId, Object params) throws Exception {
		printQueryId(queryId);
		return sqlSession.update(queryId, params);
	}

	public Object delete(String queryId, Object params) throws Exception {
		printQueryId(queryId);
		return sqlSession.delete(queryId, params);
	}

	public Object selectOne(String queryId) throws Exception {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId);
	}

	public Object selectOne(String queryId, Object params) throws Exception {
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
	}

	public List selectList(String queryId) throws Exception {
		printQueryId(queryId);
		return sqlSession.selectList(queryId);
	}

	public List selectList(String queryId, Object params) throws Exception {
		printQueryId(queryId);
		return sqlSession.selectList(queryId, params);
	}

}
