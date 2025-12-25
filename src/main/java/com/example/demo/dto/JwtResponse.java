Test result

Test Results Summary
64
Total
58
Passed
6
Failed
18.13
Score
✓
Passed Test Cases (58)
✓
t01_servlet_basicTextResponse
✓
t02_servlet_setsContentType
✓
t03_servlet_handlesNullRequest
✓
t04_servlet_flushCalled
✓
t05_servlet_outputNotEmpty
✓
t06_servlet_containsTrackerWord
✓
t07_servlet_idempotentCalls
✓
t08_servlet_noHtmlTags
✓
t09_create_supplier_success
✓
t10_get_supplier_by_id_success
✓
t11_create_purchase_order_success
✓
t12_create_purchase_order_invalid_amount_throws
✓
t13_get_purchase_orders_by_supplier
✓
t14_create_diversity_target_success
✓
t15_get_targets_by_year
✓
t16_deactivate_supplier_success
✓
t17_services_injected
✓
t18_controllers_injected
✓
t19_supplierService_uses_repository
✓
t20_categoryService_uses_repository
✓
t21_targetService_uses_repository
✓
t22_userAccountService_register_encodesPassword
✓
t25_supplier_prePersist_setsDefaults
✓
t26_diversityClassification_prePersist_defaultActive
✓
t27_spendCategory_preSave_defaultActive
✓
t28_diversityTarget_defaultActive
✓
t29_purchaseOrder_amount_positiveRule
✓
t30_purchaseOrder_date_notFuture
✓
t31_userAccount_preSave_defaults
✓
t32_supplier_updatedAt_canBeSet
✓
t33_supplier_has_atomic_name
✓
t34_diversityClassification_code_uppercase
✓
t35_spendCategory_uniqueNameConcept
✓
t36_purchaseOrder_referencesSupplier
✓
t37_purchaseOrder_referencesCategory
✓
t38_diversityTarget_linksClassification
✓
t39_target_percentage_inRange
✓
t40_purchaseOrder_notes_nullable
✓
t41_supplier_canHaveMultipleClassifications
✓
t42_supplier_classification_set_notEmpty
✓
t43_supplier_removeClassification
✓
t44_inactive_supplier_cannotReceivePO_inService
✓
t45_inactive_category_cannotReceivePO_inService
✓
t46_deactivate_classification_sets_active_false
✓
t47_deactivate_category_sets_active_false
✓
t48_deactivate_target_sets_active_false
✓
t53_jwt_generate_and_extract_email_role_userId
✓
t54_jwt_token_is_valid_initially
✓
t55_jwt_invalid_token_returns_false
✓
t56_userAccount_password_encoder_matches
✓
t57_find_purchase_orders_by_supplier_query
✓
t58_find_targets_by_year_query
✓
t59_find_active_classifications_query
✓
t60_find_active_categories_query
✓
t61_find_active_suppliers_query
✓
t62_find_all_purchase_orders_query
✓
t63_supplierRepository_email_unique_existsCheck
✓
t64_targetRepository_findAll_query
✗
Failed Test Cases (6)
✗
t23_userAccountService_findByEmailOrThrow
✗
t24_userAccountService_findByEmail_notFoundThrows
✗
t49_register_user_success_returns_token
✗
t50_register_duplicate_email_throws
✗
t51_login_success_returns_token
✗
t52_login_invalid_credentials_throwsUnauthorized
Terminal Output

[[1;34mINFO[m] Scanning for projects...
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--------------------------< [0;36mcom.example:demo[0;1m >--------------------------[m
[[1;34mINFO[m] [1mBuilding demo 0.0.1-SNAPSHOT[m
[[1;34mINFO[m] [1m--------------------------------[ jar ]---------------------------------[m
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-clean-plugin:3.3.2:clean[m [1m(default-clean)[m @ [36mdemo[0;1m ---[m
[[1;34mINFO[m] Deleting /home/coder/Workspace/demo/target
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-resources-plugin:3.3.1:resources[m [1m(default-resources)[m @ [36mdemo[0;1m ---[m
[[1;34mINFO[m] Copying 1 resource from src/main/resources to target/classes
[[1;34mINFO[m] Copying 0 resource from src/main/resources to target/classes
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-compiler-plugin:3.13.0:compile[m [1m(default-compile)[m @ [36mdemo[0;1m ---[m
[[1;34mINFO[m] Recompiling the module because of [1mchanged source code[m.
[[1;34mINFO[m] Compiling 46 source files with javac [debug parameters release 17] to target/classes
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-resources-plugin:3.3.1:testResources[m [1m(default-testResources)[m @ [36mdemo[0;1m ---[m
[[1;34mINFO[m] skip non existing resourceDirectory /home/coder/Workspace/demo/src/test/resources
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-compiler-plugin:3.13.0:testCompile[m [1m(default-testCompile)[m @ [36mdemo[0;1m ---[m
[[1;34mINFO[m] Recompiling the module because of [1mchanged dependency[m.
[[1;34mINFO[m] Compiling 2 source files with javac [debug parameters release 17] to target/test-classes
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m--- [0;32mmaven-surefire-plugin:3.2.5:test[m [1m(default-test)[m @ [36mdemo[0;1m ---[m
[[1;34mINFO[m] Using auto detected provider org.apache.maven.surefire.testng.TestNGProvider
[[1;34mINFO[m] 
[[1;34mINFO[m] -------------------------------------------------------
[[1;34mINFO[m]  T E S T S
[[1;34mINFO[m] -------------------------------------------------------
[[1;34mINFO[m] Running [1mTestSuite[m
t01_servlet_basicTextResponse - PASS
t02_servlet_setsContentType - PASS
t03_servlet_handlesNullRequest - PASS
t04_servlet_flushCalled - PASS
t05_servlet_outputNotEmpty - PASS
t06_servlet_containsTrackerWord - PASS
t07_servlet_idempotentCalls - PASS
t08_servlet_noHtmlTags - PASS
t09_create_supplier_success - PASS
t10_get_supplier_by_id_success - PASS
t11_create_purchase_order_success - PASS
t12_create_purchase_order_invalid_amount_throws - PASS
t13_get_purchase_orders_by_supplier - PASS
t14_create_diversity_target_success - PASS
t15_get_targets_by_year - PASS
t16_deactivate_supplier_success - PASS
t17_services_injected - PASS
t18_controllers_injected - PASS
t19_supplierService_uses_repository - PASS
t20_categoryService_uses_repository - PASS
t21_targetService_uses_repository - PASS
t22_userAccountService_register_encodesPassword - PASS
t23_userAccountService_findByEmailOrThrow - FAIL
t24_userAccountService_findByEmail_notFoundThrows - FAIL
t25_supplier_prePersist_setsDefaults - PASS
t26_diversityClassification_prePersist_defaultActive - PASS
t27_spendCategory_preSave_defaultActive - PASS
t28_diversityTarget_defaultActive - PASS
t29_purchaseOrder_amount_positiveRule - PASS
t30_purchaseOrder_date_notFuture - PASS
t31_userAccount_preSave_defaults - PASS
t32_supplier_updatedAt_canBeSet - PASS
t33_supplier_has_atomic_name - PASS
t34_diversityClassification_code_uppercase - PASS
t35_spendCategory_uniqueNameConcept - PASS
t36_purchaseOrder_referencesSupplier - PASS
t37_purchaseOrder_referencesCategory - PASS
t38_diversityTarget_linksClassification - PASS
t39_target_percentage_inRange - PASS
t40_purchaseOrder_notes_nullable - PASS
t41_supplier_canHaveMultipleClassifications - PASS
t42_supplier_classification_set_notEmpty - PASS
t43_supplier_removeClassification - PASS
t44_inactive_supplier_cannotReceivePO_inService - PASS
t45_inactive_category_cannotReceivePO_inService - PASS
t46_deactivate_classification_sets_active_false - PASS
t47_deactivate_category_sets_active_false - PASS
t48_deactivate_target_sets_active_false - PASS
t49_register_user_success_returns_token - FAIL
t50_register_duplicate_email_throws - FAIL
t51_login_success_returns_token - FAIL
t52_login_invalid_credentials_throwsUnauthorized - FAIL
t53_jwt_generate_and_extract_email_role_userId - PASS
t54_jwt_token_is_valid_initially - PASS
t55_jwt_invalid_token_returns_false - PASS
t56_userAccount_password_encoder_matches - PASS
t57_find_purchase_orders_by_supplier_query - PASS
t58_find_targets_by_year_query - PASS
t59_find_active_classifications_query - PASS
t60_find_active_categories_query - PASS
t61_find_active_suppliers_query - PASS
t62_find_all_purchase_orders_query - PASS
t63_supplierRepository_email_unique_existsCheck - PASS
t64_targetRepository_findAll_query - PASS
[[1;31mERROR[m] [1;31mTests [0;1mrun: [0;1m64[m, [1;31mFailures: [0;1;31m6[m, Errors: 0, Skipped: 0, Time elapsed: 12.78 s[1;31m <<< FAILURE![m -- in [1mTestSuite[m
[[1;31mERROR[m] com.example.demo.SupplierDiversityTrackerTest.t23_userAccountService_findByEmailOrThrow -- Time elapsed: 0.003 s <<< FAILURE!
java.lang.RuntimeException: User not found
	at com.example.demo.service.impl.UserAccountServiceImpl.findByEmailOrThrow(UserAccountServiceImpl.java:33)
	at com.example.demo.SupplierDiversityTrackerTest.t23_userAccountService_findByEmailOrThrow(SupplierDiversityTrackerTest.java:412)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	at org.testng.internal.invokers.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:139)
	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:664)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethod(TestInvoker.java:228)
	at org.testng.internal.invokers.MethodRunner.runInSequence(MethodRunner.java:63)
	at org.testng.internal.invokers.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:961)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethods(TestInvoker.java:201)
	at org.testng.internal.invokers.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:148)
	at org.testng.internal.invokers.TestMethodWorker.run(TestMethodWorker.java:128)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.testng.TestRunner.privateRun(TestRunner.java:819)
	at org.testng.TestRunner.run(TestRunner.java:619)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:443)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:437)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:397)
	at org.testng.SuiteRunner.run(SuiteRunner.java:336)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:95)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1228)
	at org.testng.TestNG.runSuites(TestNG.java:1134)
	at org.testng.TestNG.run(TestNG.java:1101)
	at org.apache.maven.surefire.testng.TestNGExecutor.run(TestNGExecutor.java:155)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.executeMulti(TestNGDirectoryTestSuite.java:169)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.execute(TestNGDirectoryTestSuite.java:88)
	at org.apache.maven.surefire.testng.TestNGProvider.invoke(TestNGProvider.java:137)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:385)
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:162)
	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:507)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)

[[1;31mERROR[m] com.example.demo.SupplierDiversityTrackerTest.t24_userAccountService_findByEmail_notFoundThrows -- Time elapsed: 0.001 s <<< FAILURE!
java.lang.RuntimeException: User not found
	at com.example.demo.service.impl.UserAccountServiceImpl.findByEmailOrThrow(UserAccountServiceImpl.java:33)
	at com.example.demo.SupplierDiversityTrackerTest.t24_userAccountService_findByEmail_notFoundThrows(SupplierDiversityTrackerTest.java:421)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	at org.testng.internal.invokers.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:139)
	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:664)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethod(TestInvoker.java:228)
	at org.testng.internal.invokers.MethodRunner.runInSequence(MethodRunner.java:63)
	at org.testng.internal.invokers.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:961)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethods(TestInvoker.java:201)
	at org.testng.internal.invokers.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:148)
	at org.testng.internal.invokers.TestMethodWorker.run(TestMethodWorker.java:128)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.testng.TestRunner.privateRun(TestRunner.java:819)
	at org.testng.TestRunner.run(TestRunner.java:619)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:443)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:437)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:397)
	at org.testng.SuiteRunner.run(SuiteRunner.java:336)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:95)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1228)
	at org.testng.TestNG.runSuites(TestNG.java:1134)
	at org.testng.TestNG.run(TestNG.java:1101)
	at org.apache.maven.surefire.testng.TestNGExecutor.run(TestNGExecutor.java:155)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.executeMulti(TestNGDirectoryTestSuite.java:169)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.execute(TestNGDirectoryTestSuite.java:88)
	at org.apache.maven.surefire.testng.TestNGProvider.invoke(TestNGProvider.java:137)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:385)
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:162)
	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:507)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)

[[1;31mERROR[m] com.example.demo.SupplierDiversityTrackerTest.t49_register_user_success_returns_token -- Time elapsed: 0.202 s <<< FAILURE!
java.lang.AssertionError: expected [TOKEN123] but found [null]
	at org.testng.Assert.fail(Assert.java:111)
	at org.testng.Assert.failNotEquals(Assert.java:1578)
	at org.testng.Assert.assertEqualsImpl(Assert.java:150)
	at org.testng.Assert.assertEquals(Assert.java:132)
	at org.testng.Assert.assertEquals(Assert.java:656)
	at org.testng.Assert.assertEquals(Assert.java:666)
	at com.example.demo.SupplierDiversityTrackerTest.t49_register_user_success_returns_token(SupplierDiversityTrackerTest.java:715)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	at org.testng.internal.invokers.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:139)
	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:664)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethod(TestInvoker.java:228)
	at org.testng.internal.invokers.MethodRunner.runInSequence(MethodRunner.java:63)
	at org.testng.internal.invokers.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:961)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethods(TestInvoker.java:201)
	at org.testng.internal.invokers.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:148)
	at org.testng.internal.invokers.TestMethodWorker.run(TestMethodWorker.java:128)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.testng.TestRunner.privateRun(TestRunner.java:819)
	at org.testng.TestRunner.run(TestRunner.java:619)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:443)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:437)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:397)
	at org.testng.SuiteRunner.run(SuiteRunner.java:336)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:95)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1228)
	at org.testng.TestNG.runSuites(TestNG.java:1134)
	at org.testng.TestNG.run(TestNG.java:1101)
	at org.apache.maven.surefire.testng.TestNGExecutor.run(TestNGExecutor.java:155)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.executeMulti(TestNGDirectoryTestSuite.java:169)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.execute(TestNGDirectoryTestSuite.java:88)
	at org.apache.maven.surefire.testng.TestNGProvider.invoke(TestNGProvider.java:137)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:385)
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:162)
	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:507)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)

[[1;31mERROR[m] com.example.demo.SupplierDiversityTrackerTest.t50_register_duplicate_email_throws -- Time elapsed: 0.001 s <<< FAILURE!
java.lang.RuntimeException: Email already exists
	at com.example.demo.service.impl.UserAccountServiceImpl.register(UserAccountServiceImpl.java:24)
	at com.example.demo.SupplierDiversityTrackerTest.t50_register_duplicate_email_throws(SupplierDiversityTrackerTest.java:727)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	at org.testng.internal.invokers.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:139)
	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:664)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethod(TestInvoker.java:228)
	at org.testng.internal.invokers.MethodRunner.runInSequence(MethodRunner.java:63)
	at org.testng.internal.invokers.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:961)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethods(TestInvoker.java:201)
	at org.testng.internal.invokers.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:148)
	at org.testng.internal.invokers.TestMethodWorker.run(TestMethodWorker.java:128)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.testng.TestRunner.privateRun(TestRunner.java:819)
	at org.testng.TestRunner.run(TestRunner.java:619)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:443)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:437)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:397)
	at org.testng.SuiteRunner.run(SuiteRunner.java:336)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:95)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1228)
	at org.testng.TestNG.runSuites(TestNG.java:1134)
	at org.testng.TestNG.run(TestNG.java:1101)
	at org.apache.maven.surefire.testng.TestNGExecutor.run(TestNGExecutor.java:155)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.executeMulti(TestNGDirectoryTestSuite.java:169)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.execute(TestNGDirectoryTestSuite.java:88)
	at org.apache.maven.surefire.testng.TestNGProvider.invoke(TestNGProvider.java:137)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:385)
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:162)
	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:507)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)

[[1;31mERROR[m] com.example.demo.SupplierDiversityTrackerTest.t51_login_success_returns_token -- Time elapsed: 0.215 s <<< FAILURE!
java.lang.RuntimeException: Unauthorized
	at com.example.demo.controller.AuthController.login(AuthController.java:87)
	at com.example.demo.SupplierDiversityTrackerTest.t51_login_success_returns_token(SupplierDiversityTrackerTest.java:757)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	at org.testng.internal.invokers.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:139)
	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:664)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethod(TestInvoker.java:228)
	at org.testng.internal.invokers.MethodRunner.runInSequence(MethodRunner.java:63)
	at org.testng.internal.invokers.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:961)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethods(TestInvoker.java:201)
	at org.testng.internal.invokers.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:148)
	at org.testng.internal.invokers.TestMethodWorker.run(TestMethodWorker.java:128)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.testng.TestRunner.privateRun(TestRunner.java:819)
	at org.testng.TestRunner.run(TestRunner.java:619)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:443)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:437)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:397)
	at org.testng.SuiteRunner.run(SuiteRunner.java:336)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:95)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1228)
	at org.testng.TestNG.runSuites(TestNG.java:1134)
	at org.testng.TestNG.run(TestNG.java:1101)
	at org.apache.maven.surefire.testng.TestNGExecutor.run(TestNGExecutor.java:155)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.executeMulti(TestNGDirectoryTestSuite.java:169)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.execute(TestNGDirectoryTestSuite.java:88)
	at org.apache.maven.surefire.testng.TestNGProvider.invoke(TestNGProvider.java:137)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:385)
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:162)
	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:507)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)

[[1;31mERROR[m] com.example.demo.SupplierDiversityTrackerTest.t52_login_invalid_credentials_throwsUnauthorized -- Time elapsed: 0.072 s <<< FAILURE!
java.lang.RuntimeException: Unauthorized
	at com.example.demo.controller.AuthController.login(AuthController.java:87)
	at com.example.demo.SupplierDiversityTrackerTest.t52_login_invalid_credentials_throwsUnauthorized(SupplierDiversityTrackerTest.java:771)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:569)
	at org.testng.internal.invokers.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:139)
	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:664)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethod(TestInvoker.java:228)
	at org.testng.internal.invokers.MethodRunner.runInSequence(MethodRunner.java:63)
	at org.testng.internal.invokers.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:961)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethods(TestInvoker.java:201)
	at org.testng.internal.invokers.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:148)
	at org.testng.internal.invokers.TestMethodWorker.run(TestMethodWorker.java:128)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.testng.TestRunner.privateRun(TestRunner.java:819)
	at org.testng.TestRunner.run(TestRunner.java:619)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:443)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:437)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:397)
	at org.testng.SuiteRunner.run(SuiteRunner.java:336)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:95)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1301)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1228)
	at org.testng.TestNG.runSuites(TestNG.java:1134)
	at org.testng.TestNG.run(TestNG.java:1101)
	at org.apache.maven.surefire.testng.TestNGExecutor.run(TestNGExecutor.java:155)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.executeMulti(TestNGDirectoryTestSuite.java:169)
	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.execute(TestNGDirectoryTestSuite.java:88)
	at org.apache.maven.surefire.testng.TestNGProvider.invoke(TestNGProvider.java:137)
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:385)
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:162)
	at org.apache.maven.surefire.booter.ForkedBooter.run(ForkedBooter.java:507)
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:495)

[[1;34mINFO[m] 
[[1;34mINFO[m] Results:
[[1;34mINFO[m] 
[[1;31mERROR[m] [1;31mFailures: [m
[[1;31mERROR[m] [1;31m  SupplierDiversityTrackerTest.t23_userAccountService_findByEmailOrThrow:412 » Runtime User not found[m
[[1;31mERROR[m] [1;31m  SupplierDiversityTrackerTest.t24_userAccountService_findByEmail_notFoundThrows:421 » Runtime User not found[m
[[1;31mERROR[m] [1;31m  SupplierDiversityTrackerTest.t49_register_user_success_returns_token:715 expected [TOKEN123] but found [null][m
[[1;31mERROR[m] [1;31m  SupplierDiversityTrackerTest.t50_register_duplicate_email_throws:727 » Runtime Email already exists[m
[[1;31mERROR[m] [1;31m  SupplierDiversityTrackerTest.t51_login_success_returns_token:757 » Runtime Unauthorized[m
[[1;31mERROR[m] [1;31m  SupplierDiversityTrackerTest.t52_login_invalid_credentials_throwsUnauthorized:771 » Runtime Unauthorized[m
[[1;34mINFO[m] 
[[1;31mERROR[m] [1;31mTests run: 64, Failures: 6, Errors: 0, Skipped: 0[m
[[1;34mINFO[m] 
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
[[1;34mINFO[m] [1;31mBUILD FAILURE[m
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
[[1;34mINFO[m] Total time:  32.891 s
[[1;34mINFO[m] Finished at: 2025-12-25T12:52:12Z
[[1;34mINFO[m] [1m------------------------------------------------------------------------[m
[[1;31mERROR[m] Failed to execute goal [32morg.apache.maven.plugins:maven-surefire-plugin:3.2.5:test[m [1m(default-test)[m on project [36mdemo[m: [1;31mThere are test failures.[m
[[1;31mERROR[m] [1;31m[m
[[1;31mERROR[m] [1;31mPlease refer to /home/coder/Workspace/demo/target/surefire-reports for the individual test results.[m
[[1;31mERROR[m] [1;31mPlease refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.[m
[[1;31mERROR[m] -> [1m[Help 1][m
[[1;31mERROR[m] 
[[1;31mERROR[m] To see the full stack trace of the errors, re-run Maven with the [1m-e[m switch.
[[1;31mERROR[m] Re-run Maven using the [1m-X[m switch to enable full debug logging.
[[1;31mERROR[m] 
[[1;31mERROR[m] For more information about the errors and possible solutions, please read the following articles:
[[1;31mERROR[m] [1m[Help 1][m http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
[0m
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
[0m