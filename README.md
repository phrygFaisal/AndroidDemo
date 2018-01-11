# AndroidDemo

1. To run the tests, simply use the MyTaxiTestSuite class as point of entry. It will run all the test classes in sequence.

2. Current limitation: Instrumented tests FAIL at CircleCI since in the emulator, everytime the app to test is installed, it requires location permission to be ALLOWED. The current espressor solution does not handle that.

3. To run from command line use the following snippet, 
./gradlew -Pandroid.testInstrumentationRunnerArguments.class=com.mytaxi.android_demo.MyTaxiTestSuite connectedAndroidTest -PdisablePreDex

4. All tests are GREEN in almost every run, however some runs may FAIL sometimes which are observed as PASSED on next run.

5. App doesnot logut automatically after the run of the last test. Please logout the app manually after completing test run for consecutive test runs.

6. Utility classes do NOT perform any tests but provide the tools needed to conduct the tests.
