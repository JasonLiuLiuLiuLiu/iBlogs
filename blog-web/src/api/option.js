import request from '../utils/request'

export function getOptions(keys) {
  return request({
    url: '/option/getOptions',
    method: 'post',
    data: keys
  })
}
