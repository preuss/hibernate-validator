// $Id$
/*
* JBoss, Home of Professional Open Source
* Copyright 2009, Red Hat, Inc. and/or its affiliates, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.hibernate.validator.test.constraints.impl;

import junit.framework.Assert;
import org.hibernate.validator.constraints.impl.PastValidatorForAbstractPartial;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Partial;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Kevin Pollet
 */
public class PastValidatorForAbstractPartialTest {

     private static PastValidatorForAbstractPartial validator;

     @BeforeClass
     public static void init() {
        validator = new PastValidatorForAbstractPartial();
     }

     @Test
     public void testIsValidForPartial() {
         Partial future = new Partial(new LocalDate().plusYears(1));
         Partial past = new Partial(new LocalDate().minusYears(1));

         Assert.assertTrue(validator.isValid(null, null));
         Assert.assertTrue(validator.isValid(past, null));
         Assert.assertFalse(validator.isValid(new LocalDate(), null));
         Assert.assertFalse(validator.isValid(future, null));

     }

     @Test
     public void testIsValidForLocalDate() {
         LocalDate future = new LocalDate().plusYears(1);
         LocalDate past = new LocalDate().minusYears(1);

         Assert.assertTrue(validator.isValid(null, null));
         Assert.assertTrue(validator.isValid(past, null));
         Assert.assertFalse(validator.isValid(new LocalDate(), null));
         Assert.assertFalse(validator.isValid(future, null));

     }

     @Test
     public void testIsValidForLocalTime() {
         LocalTime future = new LocalTime().plusHours(1);
         LocalTime past = new LocalTime().minusHours(1);

         Assert.assertTrue(validator.isValid(null, null));
         Assert.assertTrue(validator.isValid(past, null));
         Assert.assertFalse(validator.isValid(new LocalTime(), null));
         Assert.assertFalse(validator.isValid(future, null));

     }

     @Test
     public void testIsValidForLocalDateTime() {
         LocalDateTime future = new LocalDateTime().plusYears(1);
         LocalDateTime past = new LocalDateTime().minusYears(1);

         Assert.assertTrue(validator.isValid(null, null));
         Assert.assertTrue(validator.isValid(past, null));
         Assert.assertFalse(validator.isValid(new LocalDateTime(), null));
         Assert.assertFalse(validator.isValid(future, null));

     }

   
    
}
