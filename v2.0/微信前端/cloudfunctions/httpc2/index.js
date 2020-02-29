// 云函数入口文件
process.env.NODE_TLS_REJECT_UNAUTHORIZED = '0';
const cloud = require('wx-server-sdk')
var request = require('request');

cloud.init()
  /*
// 云函数入口函数
exports.main = async (event, context) => {
  var url = "";  //写入域名或者云服务器ip
  var requestData = "需要传输的数据";
  request({
    url: url,
    method: "GET",
    json: true,
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(requestData)
  }, function (error, response, body) {
    if (!error && response.statusCode == 200) {
      console.log(body) // 请求成功的处理逻辑
    }
  });
} */


/*
exports.main = async (event, context) => {
  var url = "";//写入域名或者云服务器ip
  var requestData = "需要传输的数据";
  request({
    url: url,
    method: "GET",
    json: true,
    headers: {
      "content-type": "application/json",
    },
    body: JSON.parse(requestData)
  }, function (error, response, body) {
    if (!error && response.statusCode == 200) {
      console.log(body) // 请求成功的处理逻辑
    }
  });
}*/



exports.main = async (event, context) => {
  request({
    timeout: 5000,    // 设置超时
    method: 'GET',    //请求方式
    url: '', //url
    qs: {                                                  //参数，注意get和post的参数设置一样  
      username: "test",
    }

  }, function (error, response, body) {
    if (!error && response.statusCode == 200) {
      console.log(body);
    } else {
      console.log("error");
    }
  });

}



