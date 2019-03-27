package link.lycreate.bluefatty.service.impl;

import link.lycreate.bluefatty.dao.UniversityDao;
import link.lycreate.bluefatty.service.UniversityService;
import link.lycreate.bluefatty.utils.UniversityResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UniversityServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/26 0:31
 */
@Service
public class UniversityServiceImpl implements UniversityService {
    @Resource
    public UniversityDao universityDao;

    @Override
    public  Map<String,Object> getAllUniversity() {
        Map<String,Object> university=universityDao.selectUniversityMap();
        return university;
    }
}
