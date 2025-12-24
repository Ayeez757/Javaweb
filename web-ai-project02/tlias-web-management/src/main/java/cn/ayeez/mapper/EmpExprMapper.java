package cn.ayeez.mapper;

import cn.ayeez.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {


    void insertBatch(List<EmpExpr> empExprList);
}
