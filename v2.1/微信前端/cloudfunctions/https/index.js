// 云函数入口文件
var cloud = require('wx-server-sdk')
var request = require('request');

cloud.init()


exports.main = async (event, context) => {
  return new Promise((resolve, reject) => {
  request({
    url: '',     //填写你的url
    method: 'GET',    //请求方式
    qs: {
      username: event.username,
      //userphone: event.userphone,
      //userlocal: event.userlocal
    },
    header: {
      'content-type': 'application/json' // 默认值
    },
  }, function (error, response, body) {
    if (!error) {
      console.log(body);
      //return true
    } else {
      console.log("error");
    }
  })
  })
}




