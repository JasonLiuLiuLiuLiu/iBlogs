import request from '../utils/request'

export function getComments(cid, pageNum, pageSize) {
  return request({
    url: '/comment/getComments',
    method: 'get',
    params: {
      cid,
      pageNum,
      pageSize
    }
  })
}
