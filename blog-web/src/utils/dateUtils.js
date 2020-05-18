// 这个函数 网上  随处可见，我也是应用了别人的。
export function dateFormat(date, fmt) {
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
  }
  let o = {
    'Y+': date.getFullYear(),
    'M+': date.getMonth(),
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  };
  for (let k in o) {
    if (new RegExp(`(${k})`).test(fmt)) {
      let str = o[k] + '';
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
    }
  }
  return fmt;
};

export function dateDifToNow(d1) {//di作为一个变量传进来
  //如果时间格式是正确的，那下面这一步转化时间格式就可以不用了
  const dateBegin = new Date(d1.replace(/-/g, "/"));//将-转化为/，使用new Date
  const dateEnd = new Date();//获取当前时间
  const dateDiff = dateEnd.getTime() - dateBegin.getTime();//时间差的毫秒数
  const dayDiff = Math.floor(dateDiff / (24 * 3600 * 1000));//计算出相差天数
  const leave1 = dateDiff % (24 * 3600 * 1000);    //计算天数后剩余的毫秒数
  const hours = Math.floor(leave1 / (3600 * 1000));//计算出小时数
  //计算相差分钟数
  const leave2 = leave1 % (3600 * 1000);    //计算小时数后剩余的毫秒数
  const minutes = Math.floor(leave2 / (60 * 1000));//计算相差分钟数
  return dayDiff+"天 "+hours+"时 "+minutes+" 分"
}


function padLeftZero(str) {
  return ('00' + str).substr(str.length);
}
