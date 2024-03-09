package com.test.fkredis.pojo.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;

@Data
@Accessors(chain = true)
@ApiModel
//@JacksonXmlRootElement(localName = "response")
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("成绩")
    private Double score;

    @ApiModelProperty("时间")
    @JsonProperty("timestamp_utc_json")
//    @JacksonXmlProperty(localName = "timestamp_utc_xml")
    @XmlAttribute(name = "timestamp_utc_JAXB")
    @JsonFormat(timezone="GTM+8",pattern="yyyy-MM-dd HH:mm:ss")
    private Instant timestampUtc;
}
