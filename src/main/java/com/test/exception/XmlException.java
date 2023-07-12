package com.test.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: roy
 * @date: 2023/7/12 21:22
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class XmlException extends RuntimeException {
    private  ExceptionEnum exceptionEnum;
}
