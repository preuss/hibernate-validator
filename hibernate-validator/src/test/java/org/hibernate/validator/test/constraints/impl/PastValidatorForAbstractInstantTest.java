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
import org.hibernate.validator.constraints.impl.FutureValidatorForAbstractInstant;
import org.hibernate.validator.constraints.impl.PastValidatorForAbstractInstant;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.MutableDateTime;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Kevin Pollet
 */
public class PastValidatorForAbstractInstantTest {

     private static PastValidatorForAbstractInstant validator;

     @BeforeClass
     public static void init() {
        validator = new PastValidatorForAbstractInstant();         
     }

     @Test
     public void testIsValidForInstant() {
         Instant future = new Instant().plus(31557600000l);
         Instant past = new Instant().minus(31557600000l);

         Assert.assertTrue(validator.isValid(null, null));
         Assert.assertTrue(validator.isValid(past, null));
         Assert.assertFalse(validator.isValid(new DateTime(), null));
         Assert.assertFalse(validator.isValid(future, null));

     }

     @Test
     public void testIsValidForDateTime() {
         DateTime future = new DateTime().plusYears(1);
         DateTime past = new DateTime().minusYears(1);

         Assert.assertTrue(validator.isValid(null, null));
         Assert.assertTrue(validator.isValid(past, null));
         Assert.assertFalse(validator.isValid(new DateTime(), null));
         Assert.assertFalse(validator.isValid(future, null));

     }

     @Test
     public void testIsValidForDateMidnight() {
         DateMidnight future = new DateMidnight().plusYears(1);
         DateMidnight past = new DateMidnight().minusYears(1);

         Assert.assertTrue(validator.isValid(null, null));
         Assert.assertTrue(validator.isValid(past, null));
         Assert.assertTrue(validator.isValid(new DateMidnight(), null));
         Assert.assertFalse(validator.isValid(future, null));

     }

     @Test
     public void testIsValidForMutableDateTime() {
         MutableDateTime future = new MutableDateTime();
         future.addYears(1);

         MutableDateTime past = new MutableDateTime();
         past.addYears(-1);

         Assert.assertTrue(validator.isValid(null, null));
         Assert.assertTrue(validator.isValid(past, null));
         Assert.assertFalse(validator.isValid(new MutableDateTime(), null));
         Assert.assertFalse(validator.isValid(future, null));

     }
    
}
