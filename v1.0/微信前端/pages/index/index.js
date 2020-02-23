Page({
  userNameInput: function (e) {
    this.setData({
      userName: e.detail.value
    })
  },
  bindtest: function () {
    
    wx.request({
      url: 'http://localhost:8080/testServlet/test',  //本地服务器地址
      data: {
        username: this.data.userName
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' //默认值
      },
      success: function (res) {
        console.log(res.data);
      },
      fail: function (res) {
        console.log("fail");
      }
    })
  }
})
