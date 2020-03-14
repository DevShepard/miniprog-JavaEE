let i = 0
Page({
  userNameInput: function (e) {
    this.setData({
      userName: e.detail.value
    })
  },

  bindtest: function () {

      wx.cloud.callFunction({ //调用云函数
        name: 'https',
        data: {
          username: this.data.userName,
          //userphone: this.data.userPhone,
          //userlocal: this.data.userLocal
        },         //云函数名为http
      })
    
  }
})
