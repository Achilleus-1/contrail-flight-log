import pathlib
import unittest
import xml.etree.ElementTree as ET

ROOT = pathlib.Path(__file__).resolve().parents[1] / 'app/src/main'

class PrivacyRegressionTests(unittest.TestCase):
    def test_demo_does_not_collect_credentials(self):
        for name in ('activity_login.xml', 'activity_forgot_password.xml'):
            tree = ET.parse(ROOT / 'res/layout' / name)
            self.assertFalse(any(node.tag.endswith('EditText') for node in tree.iter()))
        for path in (ROOT / 'java').rglob('*.java'):
            text = path.read_text()
            self.assertNotIn('Password is:', text)
            self.assertNotIn('PASS:', text)
            self.assertNotIn('Writing " + content', text)

    def test_private_files_excluded_from_every_backup_channel(self):
        tree = ET.parse(ROOT / 'res/xml/data_extraction_rules.xml')
        channels = [tree.getroot().find(name) for name in ('cloud-backup', 'device-transfer')]
        channels.append(ET.parse(ROOT / 'res/xml/backup_rules.xml').getroot())
        for channel in channels:
            excluded = {(x.get('domain'), x.get('path')) for x in channel.findall('exclude')}
            self.assertTrue({('file', 'credentials.csv'), ('file', 'logs.csv')} <= excluded)
