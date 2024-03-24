INSERT INTO permission (order_number, resource, action, resource_type, description)
VALUES (1, '/admin-auth-service/api/v1/permissions/**', 'POST', 'URL', '권한 등록 권한')
     , (1, '/admin-auth-service/api/v1/permissions/**', 'GET', 'URL', '권한 조회 권한')
     , (1, '/admin-auth-service/api/v1/permissions/**', 'PUT', 'URL', '권한 수정 권한')
     , (1, '/admin-auth-service/api/v1/permissions/**', 'DELETE', 'URL', '권한 삭제 권한')
;

INSERT INTO policy (name, description, effect)
VALUES ('PERMISSION_MANAGEMENT_POLICY', '권한 관리 정책', 'ALLOW');

INSERT INTO policy_permission (policy_id, permission_id)
VALUES (1, 1)
     , (1, 2)
     , (1, 3)
     , (1, 4);

INSERT INTO conditions (code, description)
VALUES ('IPADDRESS', '지정된 IP 주소 또는 범위')
     , ('NOT_IPADDRESS', '지정된 IP 주소 또는 범위를 제외한 모든 IP 주소');

INSERT INTO policy_CONDITIONS (policy_id, condition_code_id, values)
VALUES (1, 1, '{"IpAddress": {"SourceIp": "203.0.113.0/24"}}')
;