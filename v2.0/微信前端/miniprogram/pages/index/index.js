Page({
  userNameInput: function (e) {
    this.setData({
      userName: e.detail.value
    })
  },
  bindtest: function () {
    wx.cloud.callFunction({ //调用云函数
      name: 'httpc2'           //云函数名为http
    })
  }
})
