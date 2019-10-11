package com.zxw.excle.excle;

import com.zxw.excle.excle.code.ExcelUtils;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("get")
public class TestController {

    @GetMapping("/excle")
    public void getExcle(HttpServletResponse response) {

        //导出
        ExcelUtils excelUtils = ExcelUtils.initialization();
        // 数据列表
        List<List<String[]>> dataList = Lists.newArrayList();
        //数据列表  因为需要定义表头信息 所以需要先定义 然后将表头信息添加进去 然后将数据追加拼接
        List<String[]> stringList = Lists.newArrayList();
        // 单行数据内容
        String[] valueString = new String[]{};
        // excel表头
        String[] headerString = new String[]{"编号", "提报部门", "监控保障", "整改情况", "提报时间", "提报方式", "级别", "隐患名称", "隐患描述", "隐患类型", "隐患质量",
                "整治部门", "整改状态", "是否展示"};
        stringList.add(headerString);

        for (int i = 0; i < 10; i++) {
            int xuhao = i + 1;
            valueString = new String[]{xuhao + "",
                    "bbbbbbbbbbbbbbbbbbbb",
                    "ccccccccccccccccccccc",
                    "dddddddddddddddddddddd",
                    "eeeeeeeeeeeeeeeeeeeeeeeeeeee",
                    "ffffffffffffffffffffff",
                    "gggggggggggggggggggggggggg",
                    "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
                    "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii",
                    "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj",
                    "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk",
                    "lllllllllllllllllllllllllllllllll",
                    "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm",
                    "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
            };
            stringList.add(valueString);
        }
        // 将所有的信息哦存进dataList中
        dataList.add(stringList);
        response.reset();
        excelUtils.setResponse(response);
        excelUtils.setDataLists(dataList);
        excelUtils.setSheetName(new String[]{"隐患库"});
        excelUtils.setFileName("隐患库");
        excelUtils.exportForExcelsOptimize();
    }
}
