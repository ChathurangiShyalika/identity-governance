/*
 *
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.identity.user.endpoint.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.IObjectFactory;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import org.wso2.carbon.identity.recovery.signup.UserSelfRegistrationManager;
import org.wso2.carbon.identity.user.endpoint.Util.Utils;
import org.wso2.carbon.identity.user.endpoint.dto.CodeValidationRequestDTO;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testng.Assert.assertEquals;


/**
 * This class contains Unit tests for ValidateCodeApiServiceImpl.java
 */
@PrepareForTest(Utils.class)
public class ValidateCodeApiServiceImplTest extends PowerMockTestCase {

    @Mock
    private UserSelfRegistrationManager userSelfRegistrationManager;

    @InjectMocks
    private ValidateCodeApiServiceImpl validateCodeApiServiceImpl;

    @Test
    public void testValidateCodePost() {

        mockStatic(Utils.class);
        when(Utils.getUserSelfRegistrationManager()).thenReturn(userSelfRegistrationManager);
        assertEquals(validateCodeApiServiceImpl.validateCodePost(createCodeValidationRequestDTO()).getStatus(), 202);
    }

    @ObjectFactory
    public IObjectFactory getObjectFactory() {

        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }

    private CodeValidationRequestDTO createCodeValidationRequestDTO() {

        CodeValidationRequestDTO codeValidationRequestDTO = new CodeValidationRequestDTO();
        codeValidationRequestDTO.setCode("TestCode");
        return codeValidationRequestDTO;
    }
}
