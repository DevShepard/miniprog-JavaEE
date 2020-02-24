Page({
  userNameInput: function (e,d) {
    this.setData({
      userName: e.detail.value
    })
  },
  bindtest: function () {

    wx.request({
      url: 'http://localhost:8080/miniprog_unonline/test',  //本地服务器地址
      data: {
        username: this.data.userName
        //local: 'zzzzzzz',
        //telephone: 'zzzzzzz',
      },
      method: 'GET',
      header: {
        'content-type': 'application/json' //默认值
      },
      success: function (res) {
        console.log(res.data);
      },
      fail: function (res) {
        console.log("失败");
      }
    })
  }
})
