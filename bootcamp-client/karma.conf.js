// Karma configuration file, see link for more information
// https://karma-runner.github.io/1.0/config/configuration-file.html

module.exports = function (config) {
  config.set({
    basePath: '.',
    frameworks: ['jasmine', '@angular/cli'],
    plugins: [
      require('karma-jasmine'),
      //require('karma-firefox-launcher'),
      require('karma-chrome-launcher'),
      require('karma-jasmine-html-reporter'),
      require('karma-coverage-istanbul-reporter'),
      require('@angular/cli/plugins/karma')
    ],
    client:{
      clearContext: false // leave Jasmine Spec Runner output visible in browser
    },
    coverageIstanbulReporter: {
      reports: [ 'html', 'lcovonly' ],
      fixWebpackSourcePaths: true
    },
    angularCli: {
      environment: 'dev'
    },
    file: [
      "./node_modules/@material/top-app-bar/dist/mdc.top-app-bar.css",
      "./node_modules/@material/list/dist/mdc.list.css",
      "./node_modules/@material/button/dist/mdc.button.css",
      "./node_modules/@material/form-field/dist/mdc.form-field.css",
      "./node_modules/@material/textfield/dist/mdc.textfield.css"
    ],
    reporters: ['progress', 'kjhtml'],
    port: 9876,
    colors: true,
    logLevel: config.LOG_INFO,
    autoWatch: true,
    // browsers: ['Firefox'],
    browsers: ['Chrome'],
    singleRun: false
  });
};
