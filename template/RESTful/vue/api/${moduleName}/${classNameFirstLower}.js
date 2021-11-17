<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
import http from '@/utils/httpRequest'

export const baseURL = process.env.NODE_ENV !== 'production' && process.env.OPEN_PROXY ? '/proxyApi/' : window.SITE_CONFIG.baseUrl

/**
 * 列表查询
 * @param {*} searchForm
 */
export function list (searchForm) {
  return http({
    url: baseURL + '/${moduleName}/${classNameLower}',
    method: 'get',
    params: searchForm
  })
}

/**
 * 根据Id查询
 * @param {*} id
 */
export function findById (id) {
  return http({
    url: baseURL + '/${moduleName}/${classNameLower}/' + id,
    method: 'get'
  })
}

/**
 * 新增
 * @param {*} data
 */
export function add (data) {
  return http({
    url: baseURL + '/${moduleName}/${classNameLower}',
    method: 'post',
    data
  })
}

/**
 * 修改
 * @param {*} data
 */
export function update (data) {
  return http({
    url: baseURL + '/${moduleName}/${classNameLower}',
    method: 'put',
    data
  })
}

/**
 * 删除
 * @param {*} id
 */
export function delById (id) {
  return http({
    url: baseURL + '/${moduleName}/${classNameLower}/' + id,
    method: 'delete'
  })
}
