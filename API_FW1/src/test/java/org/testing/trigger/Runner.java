package org.testing.trigger;

import java.io.IOException;

import org.testing.testscripts.TC1;
import org.testing.testscripts.TC10;
import org.testing.testscripts.TC11;
import org.testing.testscripts.TC2;
import org.testing.testscripts.TC3;
import org.testing.testscripts.TC4;
import org.testing.testscripts.TC5;
import org.testing.testscripts.TC7;
import org.testing.testscripts.TC8;
import org.testing.testscripts.TC9;

public class Runner 
{
public static void main(String[] args) throws IOException 
{
TC1 obj1=new TC1();
obj1.testCase1();
TC2 obj2=new TC2();
obj2.testCase2();
TC3 obj3=new TC3();
obj3.Testcase3();
TC4 obj4=new TC4();
obj4.testCase4();
TC5 obj5=new TC5();
obj5.testCase5();
TC7 obj7=new TC7();
obj7.testCase7();
TC8 obj8=new TC8();
obj8.testCase8();
TC9 obj9=new TC9();
obj9.TestCase9();
TC10 obj10=new TC10();
obj10.testCase10();
TC11 obj11=new TC11();
obj11.testCase11();
}
}
