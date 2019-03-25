package link.lycreate.bluefatty.controller;

import link.lycreate.bluefatty.model.University;
import link.lycreate.bluefatty.service.UniversityService;
import link.lycreate.bluefatty.utils.UniversityResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UniversityController
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/26 0:13
 */
@RestController
public class UniversityController {
    @Autowired
    public UniversityService universityService;
    @RequestMapping("/getUniversityInfo")
    public Map<String,Object> getUniversityInfo(){
        Map<String,Object> resultMap=new HashMap<>();
        List<UniversityResult> university=universityService.getAllUniversity();
        resultMap.put("university",university);
        return resultMap;
    }
}
