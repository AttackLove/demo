
集成测试命名
mvn clean compile verify -Dunit-tests.skip=true  surefire-report:report

单元测试命令
mvn clean compile verify -Dintegration-tests.skip=true surefire-report:report

同时测试并生成报告
mvn clean compile test surefire-report:report

测试完成会生成 target/site/surefire-report.html 报告

集成测试初始
