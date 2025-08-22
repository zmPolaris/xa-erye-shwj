package cn.xa.eyre.service;

import cn.xa.eyre.system.dict.mapper.DatasetDiseaseDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Order(99)
public class InitDiseaseDataService implements CommandLineRunner {

    @Autowired
    DatasetDiseaseDataMapper datasetDiseaseDataMapper;

    public static List<String> DATASET_DISEASE_DATA;
    @Override
    public void run(String... args) throws Exception {
        getDistinctIcd10();
    }

    private List<String> getDistinctIcd10() {
        List<String> originalList = datasetDiseaseDataMapper.selectDistinctIcd10();
        DATASET_DISEASE_DATA = originalList.stream()
                .filter(Objects::nonNull) // 过滤掉原始列表中的 null 元素
                .flatMap(s -> {
                    if (s.contains("、")) {
                        // 如果包含中文顿号，按 "、" 分割并返回流
                        return Arrays.stream(s.split("、"))
                                .filter(Objects::nonNull) // 过滤掉分割后的 null
                                .filter(str -> !str.isEmpty()); // 过滤掉空字符串
                    } else {
                        // 否则返回单元素流
                        return Stream.of(s);
                    }
                })
                .collect(Collectors.toList());
        return DATASET_DISEASE_DATA;
    }

    public List<String> getDiseaseDate() {
        if (DATASET_DISEASE_DATA != null && !DATASET_DISEASE_DATA.isEmpty()) {
            return DATASET_DISEASE_DATA;
        } else {
            return getDistinctIcd10();
        }
    }
}
