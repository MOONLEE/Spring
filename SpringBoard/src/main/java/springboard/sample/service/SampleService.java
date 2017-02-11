package springboard.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {
	public List<Map<String, Object>> selectBoard(Map<String, Object> commonMap) throws Exception;
	public void insertBoard(Map<String, Object> commonMap) throws Exception;
	public Map<String, Object> selectUserConfirm(Map<String, Object> commonMap) throws Exception;
}